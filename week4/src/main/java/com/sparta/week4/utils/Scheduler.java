package com.sparta.week4.utils;

import com.sparta.week4.models.ItemDto;
import com.sparta.week4.models.Product;
import com.sparta.week4.models.ProductRepository;
import com.sparta.week4.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
@Component
public class Scheduler {

    private final ProductRepository repository;
    private final ProductService productService;
    private final NaverShopSearch naverShopSearch;

    // 초, 분, 시, 일, 월, 주
    @Scheduled(cron = "0 0 1 * * *")
    public void updatePrice() throws InterruptedException {
        System.out.println("가격 업데이트 실행");
        List<Product> productList = repository.findAll();
        for (int i=0; i<productList.size(); i++){
            // 1초에 한 상품씩 조회
            TimeUnit.SECONDS.sleep(1);
            // i번째 관심 상품 꺼내기
            Product p =productList.get(i);
            // i번째 관심 상품의 제목으로 검색 실행
            String title = p.getTitle();
            String resultString = naverShopSearch.search(title);
            // i번째 관심 상품의 검색 결과 목록 중 첫 번째 결과 꺼내기
            List<ItemDto> itemDtoList = naverShopSearch.fromJSONtoItems(resultString);
            ItemDto itemDto = itemDtoList.get(0);
            // i번째 관심 상품 정보를 업데이트 합니다
            Long id = p.getId();
            productService.updateBySearch(id, itemDto);
        }
    }
}
