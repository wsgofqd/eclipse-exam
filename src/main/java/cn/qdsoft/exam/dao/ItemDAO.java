package cn.qdsoft.exam.dao;

import java.util.List;

import cn.qdsoft.exam.model.Item;

public interface ItemDAO {

	Item findById(Long id);

	List<Item> findByQuestionId(Long qid);

	void save(Item m);
}
