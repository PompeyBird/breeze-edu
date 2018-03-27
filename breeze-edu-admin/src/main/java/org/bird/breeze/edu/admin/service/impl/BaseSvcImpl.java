package org.bird.breeze.edu.admin.service.impl;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author pompey
 */
@Transactional(rollbackFor=Exception.class,isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
public class BaseSvcImpl {
}
