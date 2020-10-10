package com.tensquare.base.service;

import com.tensquare.base.dao.LabelDao;
import com.tensquare.base.pojo.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.IdWorker;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Label的service层
 * <p>Compiler:fan
 * <p>版本:xxxxxxxxxx
 * <p>文件名：com.tensquare.base.service.LabelService.java
 * <p>作者: miyf
 * <p>创建时间: 2020年09月17日 18:26
 * <p>负责人:fan
 * <p>修改者： fan
 * <p>修改时间：
 */
@Service
@Transactional
public class LabelService {
    @Autowired
    private LabelDao labelDao;
    @Autowired
    private IdWorker idWorker;

    /**
     * 查询全部label
     * 日期: 18:33 2020/9/17
     * 作者: miyf
     *
     * @return List<Label>
     **/
    public List<Label> findAll() {
        return labelDao.findAll();
    }

    /**
     * 通过id查询
     * 日期: 18:34 2020/9/17
     * 作者: miyf
     *
     * @param id id
     * @return Label
     **/
    public Label findById(String id) {
        return labelDao.findById(id).get();
    }

    /**
     * 新增的方法
     * 日期: 18:34 2020/9/17
     * 作者: miyf
     *
     * @param label 待保存的label
     **/
    public void save(Label label) {
        label.setId(String.valueOf(idWorker.nextId()));
        labelDao.save(label);
    }

    /**
     * 修改的方法
     * 日期: 18:35 2020/9/17
     * 作者: miyf
     *
     * @param label 待修改的label
     **/
    public void update(Label label) {
        labelDao.save(label);
    }

    /**
     * 删除的方法
     * 日期: 18:36 2020/9/17
     * 作者: miyf
     *
     * @param id 待删除label的id
     **/
    public void delete(String id) {
        labelDao.deleteById(id);
    }

    /**
     * 条件查询的方法
     * 日期: 16:23 2020/9/22
     * 作者: miyf
     *
     * @param label 查询条件
     * @return List<Label>
     **/
    public List<Label> findSearch(Label label) {
        return labelDao.findAll(new Specification<Label>() {
            /**
             * 构建条件
             * 日期: 16:43 2020/9/22
             * 作者: miyf
             * @param root 根对象，就是把条件封装在哪个对象中。 where 类名 = label.getId。
             * @param criteriaQuery 封装的都是查询关键字，比如order by，group by等。
             * @param criteriaBuilder 用于封装条件对象的，如果直接返回null，表示没有任何条件。
             * @return Predicate
             **/
            @Override
            public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                ArrayList<Predicate> list = new ArrayList<>();
                if (label.getLabelname() != null && !"".equals(label.getLabelname())) {
                    Predicate predicate = criteriaBuilder.like(root.get("labelname").as(String.class), "%" + label.getLabelname() + "%");// where labelname like “%小明%”
                    list.add(predicate);
                }
                if (label.getState() != null && !"".equals(label.getState())) {
                    Predicate predicate = criteriaBuilder.like(root.get("state").as(String.class), label.getState());// where state  = “1”
                    list.add(predicate);
                }
                // new 一个数组作为最终返回值的条件
                Predicate[] predicates = new Predicate[list.size()];
                // 把list转化成数组(z这里会默认执行 predicates= list.toArray(predicates);)
                list.toArray(predicates);
                // 添加进去条件，and表示和，or表示或
                return criteriaBuilder.and(predicates);
            }
        });
    }

    /**
     * 分页条件查询的方法
     * 日期: 14:53 2020/10/10
     * 作者: miyf
     *
     * @param label 查询条件
     * @param page  页码
     * @param size  页大小
     * @return Result
     **/
    public Page<Label> pageQuery(Label label, int page, int size) {
        // 封装一个分页对象
        Pageable pageable = PageRequest.of(page - 1, size);
        return labelDao.findAll(new Specification<Label>() {
            /**
             * 构建条件
             * 日期: 16:43 2020/9/22
             * 作者: miyf
             * @param root 根对象，就是把条件封装在哪个对象中。 where 类名 = label.getId。
             * @param criteriaQuery 封装的都是查询关键字，比如order by，group by等。
             * @param criteriaBuilder 用于封装条件对象的，如果直接返回null，表示没有任何条件。
             * @return Predicate
             **/
            @Override
            public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                ArrayList<Predicate> list = new ArrayList<>();
                if (label.getLabelname() != null && !"".equals(label.getLabelname())) {
                    Predicate predicate = criteriaBuilder.like(root.get("labelname").as(String.class), "%" + label.getLabelname() + "%");// where labelname like “%小明%”
                    list.add(predicate);
                }
                if (label.getState() != null && !"".equals(label.getState())) {
                    Predicate predicate = criteriaBuilder.like(root.get("state").as(String.class), label.getState());// where state  = “1”
                    list.add(predicate);
                }
                // new 一个数组作为最终返回值的条件
                Predicate[] predicates = new Predicate[list.size()];
                // 把list转化成数组(z这里会默认执行 predicates= list.toArray(predicates);)
                list.toArray(predicates);
                // 添加进去条件，and表示和，or表示或
                return criteriaBuilder.and(predicates);
            }
        }, pageable);
    }
}
