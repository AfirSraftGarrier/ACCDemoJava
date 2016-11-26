/**
 * 
 * ACCTestJava - ACC Java Test Platform
 * Copyright (c) 2014, AfirSraftGarrier, afirsraftgarrier@qq.com
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 */
package com.acc.demo.java.pre;

public class LongTest {

	public static void main(String[] args) {
		Long a1 = 1l;
		Long b1 = 1l;
		System.out.println(a1 == b1);
		Long a2 = new Long(1);
		Long b2 = 1l;
		System.out.println(a2.equals(b2));
	}

}
