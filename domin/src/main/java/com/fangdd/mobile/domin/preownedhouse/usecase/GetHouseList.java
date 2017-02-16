package com.fangdd.mobile.domin.preownedhouse.usecase;

import android.support.annotation.NonNull;

import com.fangdd.mobile.domin.BaseUseCase;
import com.fangdd.mobile.domin.excutor.PostExecutionThread;
import com.fangdd.mobile.domin.excutor.ThreadExecutor;
import com.fangdd.mobile.domin.preownedhouse.entity.HouseEntity;
import com.fangdd.mobile.domin.preownedhouse.repository.HouseRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * the use case to get house data with house Id. Created by lee on 17/2/13.
 */

public class GetHouseList extends BaseUseCase<List<HouseEntity>, GetHouseList.Params> {

    private final HouseRepository houseRepository;

    @Inject
    GetHouseList(HouseRepository houseRepository, ThreadExecutor threadExecutor,
                 PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.houseRepository = houseRepository;
    }

    @Override
    protected Observable<List<HouseEntity>> buildUseCaseObservable(@NonNull Params params) {
        return this.houseRepository.getFilterHouse(params.pageIndex, params.pageSize, params.cityId, params.filterString);
    }

    public static final class Params {

        private int pageIndex;
        private int pageSize;
        private long cityId;
        private String filterString;

        private Params(int pageIndex, int pageSize, long cityId, String filterString) {
            this.pageIndex = pageIndex;
            this.pageSize = pageSize;
            this.cityId = cityId;
            this.filterString = filterString;
        }

        /**
         * @param pageIndex    the current index of the list that expected.
         * @param pageSize     the number of list size that expected.
         * @param cityId       the id information of the selected city
         * @param filterString the conditions that restrain the list of houses.
         * @return the params which contains all the information that needed in this use case.
         */
        public static Params setHouse(int pageIndex, int pageSize, long cityId, String filterString) {
            return new Params(pageIndex, pageSize, cityId, filterString);
        }
    }
}
