package com.fangdd.mobile.data.preownedhouse.repository;

import com.fangdd.mobile.domin.preownedhouse.entity.HouseEntity;
import com.fangdd.mobile.domin.preownedhouse.repository.HouseRepository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

/**
 * Created by lee on 17/2/10.
 */
@Singleton
public class HouseDataRepository implements HouseRepository {


    @Inject
    public HouseDataRepository() {
    }

    @Override
    public Observable<HouseEntity> getHouse(long houseId) {
        HouseEntity houseEntity = new HouseEntity();
        houseEntity.setId(1);
        houseEntity.setName("1号小区");
        return Observable.just(houseEntity);
    }


    @Override
    public Observable<List<HouseEntity>> getFilterHouse(int pageIndex, int pageSize, long cityId, String filterString) {
        List<HouseEntity> houses = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            HouseEntity houseEntity = new HouseEntity();
            houseEntity.setId(i);
            houseEntity.setName(i + "号小区");
            houses.add(houseEntity);
        }
        return Observable.just(houses);
    }
}
