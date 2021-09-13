package com.whcdit.imengya.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/abcd")
public class AbcdController {
	
	private final String path = "/ceshi/";
	

	@PostMapping(path + "aaa")
	public Object aaa(@RequestBody Object param) {
		Map<String, Object> res = new HashMap<>();
		int colInit = 12;
		int persons = 2;
		int count = (colInit + persons * 3);
		res.put("count", count);
		List<Map<Integer, String>> list = new ArrayList<>();
		Map<Integer, String> mapFirst = new HashMap<>();

		for (int i = 1; i <= count; i++) {
			if (i <= 12) {
				mapFirst.put(i, " ");
			} else {
				mapFirst.put(i, "资源信息");
			}

		}
		Map<Integer, String> mapSecond = new HashMap<>();
		mapSecond.put(1, "序号");
		mapSecond.put(2, "项目ID");
		mapSecond.put(3, "任务ID");
		mapSecond.put(4, "任务描述");
		mapSecond.put(5, "父节点ID");
		mapSecond.put(6, "删除标记");
		mapSecond.put(7, "任务类型");
		mapSecond.put(8, "开始日期");
		mapSecond.put(9, "结束日期");
		mapSecond.put(10, "输入工时");
		mapSecond.put(11, "TR阶段");
		mapSecond.put(12, " ");
		for (int i = 1; i <= persons; i++) {
			int key = colInit + 3 * (i - 1) + 1;
			mapFirst.put(key, "xingming");
			mapFirst.put(key + 1, "gonghao");
			mapFirst.put(key + 2, "gangwei");
			mapSecond.put(key, "开始");
			mapSecond.put(key + 1, "结束");
			mapSecond.put(key + 2, "工时");
		}
		list.add(mapFirst);
		list.add(mapSecond);
		res.put("list", list);
		return res;
	}
}
