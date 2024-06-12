package com.shq.demo.orderRibbon.custemRule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class CustomRandomRule extends AbstractLoadBalancerRule {

    @Override
    public Server choose(Object key) {
        // 获取所有可用实例
        ILoadBalancer loadBalancer = this.getLoadBalancer();
        List<Server> servers = loadBalancer.getReachableServers();
        // 生成随机数
        int index = ThreadLocalRandom.current().nextInt(servers.size());
        System.out.println("自定义负载均衡算法，随机服务下标为：" + index);
        Server server = servers.get(index);
        return server;
    }

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }
}
