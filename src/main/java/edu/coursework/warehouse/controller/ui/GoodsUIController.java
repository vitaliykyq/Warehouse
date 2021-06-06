package edu.coursework.warehouse.controller.ui;

/*
    @author:    Sasha
    @project:    Warehouse
    @class:    GoodsUIController
    @version:    1.0.0 
    @since:    26.04.2021     
*/

import edu.coursework.warehouse.model.Goods;
import edu.coursework.warehouse.model.Producer;
import edu.coursework.warehouse.model.Provider;
import edu.coursework.warehouse.service.goods.impls.GoodsServiceImpl;
import edu.coursework.warehouse.service.producer.impls.ProducerServiceImpl;
import edu.coursework.warehouse.service.provider.impls.ProviderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ui/goods")
@Controller
public class GoodsUIController {

    @Autowired
    GoodsServiceImpl goodsService;

    @Autowired
    ProviderServiceImpl providerService;

    @Autowired
    ProducerServiceImpl producerService;

    @RequestMapping("/get/all")
    public String showAll(Model model){

        List<Goods> goodsList = goodsService.getAll();
        model.addAttribute("goodsList", goodsList);

        return "goods/goodsList";
    }

    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable (value="id") String id, Model model){
        Goods goods = goodsService.getById(id);
        model.addAttribute("goods", goods);

        List<Provider> providerIdList = providerService.getAll();
        model.addAttribute("providerIdList", providerIdList);

        List<Producer> producerIdList = producerService.getAll();
        model.addAttribute("producerIdList", producerIdList);
        return "goods/updateGoods";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute("goods") @RequestBody Goods goods) {

        goodsService.update(goods);
        return "redirect:/ui/goods/get/all";
    }

    @GetMapping("/showNewForm")
    public String showNewForm(Model model) {
        Goods goods = new Goods();
        model.addAttribute("goods", goods);

        List<Provider> providerIdList = providerService.getAll();
        model.addAttribute("providerIdList", providerIdList);

        List<Producer> producerIdList = producerService.getAll();
        model.addAttribute("producerIdList", producerIdList);
        return "goods/newGoods";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute("goods") @RequestBody Goods goods) {

        model.addAttribute("goods", goodsService.create(goods));
        return "redirect:/ui/goods/get/all";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        goodsService.delete(id);
        return "redirect:/ui/goods/get/all";
    }
}
