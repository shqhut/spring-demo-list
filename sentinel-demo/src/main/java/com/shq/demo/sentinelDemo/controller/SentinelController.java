package com.shq.demo.sentinelDemo.controller;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
public class SentinelController {

    @RequestMapping(method = RequestMethod.GET, value = "/helloSentinel")
    public String helloSentinel() {
        Entry entry = null;
        // 务必保证 finally 会被执行
        try {
            // 资源名可使用任意有业务语义的字符串，注意数目不能太多（超过 1K），超出几千请作为参数传入而不要直接作为资源名
            // EntryType 代表流量类型（inbound/outbound），其中系统规则只对 IN 类型的埋点生效
            entry = SphU.entry("hello sentinel");
            // 被保护的业务逻辑
            return "hello sentinel!";
        } catch (BlockException ex) {
            // 资源访问阻止，被限流或被降级
            // 进行相应的处理操作
            return "sentinel bolcked!";
        } finally {
            // 务必保证 exit，务必保证每个 entry 与 exit 配对
            if (entry != null) {
                entry.exit();
            }
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/hello/sentinelResource/{name}")
    @SentinelResource(value = "sentinel resource", blockHandler = "blockHandlerForsentinelResource")
    public String helloSentinelResource(@PathVariable String name) {
        return "hello sentinel resource：" + name;
    }

    public String blockHandlerForsentinelResource(String name, BlockException ex) {
        ex.printStackTrace();
        return "!!!!!!hello sentinel resource blocked：" + name;
    }



    @PostConstruct
    public void initFlowRules(){
        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule = new FlowRule();
        rule.setResource("hello sentinel");
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule.setCount(1);
        rules.add(rule);

        FlowRule rule2 = new FlowRule();
        rule2.setResource("sentinel resource");
        rule2.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule2.setCount(1);
        rules.add(rule2);
        FlowRuleManager.loadRules(rules);
    }

}
