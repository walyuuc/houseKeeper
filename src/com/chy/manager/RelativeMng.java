package com.chy.manager;

import java.util.List;

import com.chy.common.Page;
import com.chy.entity.Relative;
import com.chy.entity.User;

public interface RelativeMng {

	public Page getByEmployee(Long employeeId,Page page);
}
