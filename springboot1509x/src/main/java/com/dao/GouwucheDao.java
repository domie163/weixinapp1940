package com.dao;

import com.entity.GouwucheEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.GouwucheVO;
import com.entity.view.GouwucheView;


/**
 * 购物车
 * 
 * @author 
 * @email 
 * @date 2023-02-28 09:47:02
 */
public interface GouwucheDao extends BaseMapper<GouwucheEntity> {
	
	List<GouwucheVO> selectListVO(@Param("ew") Wrapper<GouwucheEntity> wrapper);
	
	GouwucheVO selectVO(@Param("ew") Wrapper<GouwucheEntity> wrapper);
	
	List<GouwucheView> selectListView(@Param("ew") Wrapper<GouwucheEntity> wrapper);

	List<GouwucheView> selectListView(Pagination page,@Param("ew") Wrapper<GouwucheEntity> wrapper);
	
	GouwucheView selectView(@Param("ew") Wrapper<GouwucheEntity> wrapper);
	

}
