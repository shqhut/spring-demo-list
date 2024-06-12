package com.shq.demo.orderFeign.feign;

import com.shq.demo.orderFeign.config.OpenApiFeignConfig;
import com.shq.demo.orderFeign.dto.ProfileParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "openapiFeign", url = "https://lbi-api.newayz.com/openapi", configuration = OpenApiFeignConfig.class)
public interface OpenApiFeign {

    @RequestMapping(method = RequestMethod.POST, value = "/v1/crowdProfile")
    String crowdProfile(@RequestBody ProfileParam param);

    @RequestMapping(method = RequestMethod.GET, value = "/v1/gridHeat/queryAllGridHeatNonSubscription",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    String queryAllGridHeatNonSubscription(@RequestParam("disCode") String disCode,
                                           @RequestParam("queryDate") String queryDate);

}
