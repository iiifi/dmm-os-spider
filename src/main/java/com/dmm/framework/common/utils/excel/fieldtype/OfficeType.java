/**
 *
 */
package com.dmm.framework.common.utils.excel.fieldtype;

import com.dmm.framework.common.utils.StringUtils;
import com.dmm.framework.modules.sys.entity.Office;
import com.dmm.framework.modules.sys.utils.UserUtils;

/**
 * 字段类型转换
 */
public class OfficeType {

	/**
	 * 获取对象值（导入）
	 */
	public static Object getValue(String val) {
		for (Office e : UserUtils.getOfficeList()){
			if (StringUtils.trimToEmpty(val).equals(e.getName())){
				return e;
			}
		}
		return null;
	}

	/**
	 * 设置对象值（导出）
	 */
	public static String setValue(Object val) {
		if (val != null && ((Office)val).getName() != null){
			return ((Office)val).getName();
		}
		return "";
	}
}
