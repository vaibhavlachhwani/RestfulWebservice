package com.vaibhav.restfulwebservice.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.PropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filter")
    public MappingJacksonValue filter() {
        SampleBean sampleBean = new SampleBean("value1", "value2", "value3");

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(sampleBean);
        PropertyFilter propertyFilter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field3");
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("someBeanFilter", propertyFilter);
        mappingJacksonValue.setFilters(filterProvider);

        return mappingJacksonValue;
    }

    @GetMapping("/filter-list")
    public MappingJacksonValue filterList() {
        List<SampleBean> list = Arrays.asList(new SampleBean("value1", "value2", "value3"),
                new SampleBean("value11", "value22", "value33"),
                new SampleBean("value111", "value222", "value333"));

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(list);
        PropertyFilter propertyFilter = SimpleBeanPropertyFilter.filterOutAllExcept("field2", "field3");
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("someBeanFilter", propertyFilter);
        mappingJacksonValue.setFilters(filterProvider);

        return mappingJacksonValue;
    }
}
