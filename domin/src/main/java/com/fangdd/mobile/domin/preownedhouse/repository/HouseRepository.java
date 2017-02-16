package com.fangdd.mobile.domin.preownedhouse.repository;

import com.fangdd.mobile.domin.preownedhouse.entity.HouseEntity;

import java.util.List;

import io.reactivex.Observable;

/**
 * Interface that present a repository  for getting {@link HouseEntity} related data. Created by lee on 17/2/10.
 */
public interface HouseRepository {


    /**
     * @param houseId the id used to point out the related house data.
     * @return an {@link Observable} which will deliver a {@link HouseEntity}.
     */
    Observable<HouseEntity> getHouse(final long houseId);

    /**
     * @param pageIndex    the current index of the list that expected.
     * @param pageSize     the number of list size that expected.
     * @param filterString the conditions that restrain the list of houses.
     * @return an {@link Observable} which will deliver a list of {@link HouseEntity}.
     */
    Observable<List<HouseEntity>> getFilterHouse(int pageIndex, int pageSize, long cityId, String filterString);

}
