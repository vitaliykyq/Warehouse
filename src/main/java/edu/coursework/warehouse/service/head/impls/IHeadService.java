package edu.coursework.warehouse.service.head.impls;

import edu.coursework.warehouse.model.Goods;
import edu.coursework.warehouse.model.Head;

import java.util.List;

public interface IHeadService {
    Head getById(String id);
    Head create(Head head);
    Head update(Head head);
    Head delete(String id);
    List<Head> getAll();
}
