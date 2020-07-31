package com.xiaoshu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.xiaoshu.dao.DeviceMapper;
import com.xiaoshu.dao.UserMapper;
import com.xiaoshu.entity.Device;
import com.xiaoshu.entity.User;
import com.xiaoshu.entity.UserExample;
import com.xiaoshu.entity.UserExample.Criteria;

@Service
public class PhoneService {

	@Autowired
	UserMapper userMapper;

	@Autowired
	private DeviceMapper deviceMapper;
	public PageInfo<Device> findPage(Device device){
		
		 List<Device> list =deviceMapper.findAll(device);
		 return new PageInfo<>(list);
		
	}
	public void addP(Device id){
		
		 deviceMapper.insert(id);
		
	}
	public void updateP(Device device){
		deviceMapper.updateByPrimaryKeySelective(device);
	}
	public void delP(int parseInt) {
		deviceMapper.deleteByPrimaryKey(parseInt);
	}
	
	public Device findById(String name){
		Device parm=new Device();
		parm.setDeviceName(name);
		deviceMapper.selectOne(parm);
	}

}
