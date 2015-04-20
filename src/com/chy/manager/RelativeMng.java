package com.chy.manager;

import java.util.List;

import com.chy.common.Page;
import com.chy.entity.Relative;

public interface RelativeMng {

	public List<Relative> getByEmployee(Long employeeId,Page page);
}
