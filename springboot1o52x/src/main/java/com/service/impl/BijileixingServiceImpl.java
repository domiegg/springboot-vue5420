package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.BijileixingDao;
import com.entity.BijileixingEntity;
import com.service.BijileixingService;
import com.entity.vo.BijileixingVO;
import com.entity.view.BijileixingView;

@Service("bijileixingService")
public class BijileixingServiceImpl extends ServiceImpl<BijileixingDao, BijileixingEntity> implements BijileixingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<BijileixingEntity> page = this.selectPage(
                new Query<BijileixingEntity>(params).getPage(),
                new EntityWrapper<BijileixingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<BijileixingEntity> wrapper) {
		  Page<BijileixingView> page =new Query<BijileixingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<BijileixingVO> selectListVO(Wrapper<BijileixingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public BijileixingVO selectVO(Wrapper<BijileixingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<BijileixingView> selectListView(Wrapper<BijileixingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public BijileixingView selectView(Wrapper<BijileixingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
