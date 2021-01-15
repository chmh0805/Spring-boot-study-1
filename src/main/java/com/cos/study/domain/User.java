package com.cos.study.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User { // 내가 원할 때 new 하여야 하므로(제어의역전이 일어나면 안되므로) component/configuration X
	private int id;
	private String username;
	private String password;
	private String phone;
}
