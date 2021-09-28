package com.xiexin.service;

import com.xiexin.bean.Customer;
import com.xiexin.bean.CustomerExample;
import com.xiexin.dao.CustomerDAO;
import com.xiexin.util.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("customerService")
public class CustomerServiceImpl implements CustomerService{
	@Autowired(required = false)
	private CustomerDAO customerDAO;
	public long countByExample(CustomerExample example){
    	return customerDAO.countByExample(example);
    }

	public int deleteByExample(CustomerExample example){
    	return customerDAO.deleteByExample(example);
    }

	public int deleteByPrimaryKey(Integer id){
    	return customerDAO.deleteByPrimaryKey(id);
    }

	public int insert(Customer record){
    	return customerDAO.insert(record);
    }

	public int insertSelective(Customer record){
    	return customerDAO.insertSelective(record);
    }

	public List<Customer> selectByExample(CustomerExample example){
    	return customerDAO.selectByExample(example);
    }

	public Customer selectByPrimaryKey(Integer id){
    	return customerDAO.selectByPrimaryKey(id);
    }
  
	public int updateByExampleSelective(Customer record, CustomerExample example){
    	return customerDAO.updateByExampleSelective(record, example);
    }

	public int updateByExample(Customer record, CustomerExample example){
    	return customerDAO.updateByExample(record, example);
    }

	public int updateByPrimaryKeySelective(Customer record){
    	return customerDAO.updateByPrimaryKeySelective(record);
    }

	public int updateByPrimaryKey(Customer record){
    	return customerDAO.updateByPrimaryKey(record);
    }

	@Override
	public double getMoney(double gongSiLng, double gongSiLat, double customerLng, double customerLat) {
		//根据2个经纬度，算出距离km 数，.除以100得出的钱，算作人民币。

		double m = MapUtils.algorithm(gongSiLng, gongSiLat, customerLng, customerLat);//算出的距离单位是m
		//要想计算出人民币 ，最最简单的方法 3782.0129 除以 100 37.820129
		m=m/100;  //人民币  0.345  起步价！！ m小于 10元 m=10


		if(m<10){
			m=10;
		}

		return m;
	}


}
