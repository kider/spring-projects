/**
 *    Copyright 2015-2017 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */


package com.spring.boot.starter.example.dao;

import com.spring.boot.starter.example.entity.City;
import com.spring.boot.starter.example.entity.Hotel;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Eddú Meléndez
 */
@Component
public class HotelDao {

	private final SqlSession sqlSession;

	public HotelDao(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public Hotel selectByCity(City city) {
		return this.sqlSession.selectOne("selectByCity",city);
	}

	public List<Hotel> selectByHotel(Hotel hotel) {
		return this.sqlSession.selectList("selectByHotel",hotel);
	}


}
