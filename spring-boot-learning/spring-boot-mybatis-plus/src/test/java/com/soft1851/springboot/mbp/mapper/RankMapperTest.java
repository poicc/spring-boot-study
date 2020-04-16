package com.soft1851.springboot.mbp.mapper;

import com.soft1851.springboot.mbp.entity.Rank;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class RankMapperTest {

    @Resource
    private RankMapper rankMapper;

    @Test
    void testSelectAll(){
        List<Rank> ranks = rankMapper.selectList(null);
        ranks.forEach(System.out::println);
    }

    @Test
    void selectById(){
        System.out.println(rankMapper.selectById(00000000001));

    }

//    @Test
//    void selectMaps(){
//        List<Map<String, Object>> rank = rankMapper.selectMaps( "纳豆");
//    }



//    @Test
//    void insert(){
//        Rank rank = builder
//        rankMapper.insert();
//    }
}