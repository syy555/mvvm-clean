package com.fangdd.mobile.domin.preownedhouse.usecase;

import android.support.annotation.NonNull;

import com.fangdd.mobile.domin.BaseUseCase;
import com.fangdd.mobile.domin.excutor.PostExecutionThread;
import com.fangdd.mobile.domin.excutor.ThreadExecutor;
import com.fangdd.mobile.domin.preownedhouse.entity.HouseEntity;
import com.fangdd.mobile.domin.preownedhouse.repository.HouseRepository;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * the use case to get house data with house Id.
 * Created by lee on 17/2/13.
 */

public class GetHouseDetail extends BaseUseCase<HouseEntity, GetHouseDetail.Params> {

    private final HouseRepository houseRepository;

    @Inject
    GetHouseDetail(HouseRepository houseRepository, ThreadExecutor threadExecutor,
                   PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.houseRepository = houseRepository;
    }

    @Override
    protected Observable<HouseEntity> buildUseCaseObservable(@NonNull Params params) {
        return this.houseRepository.getHouse(params.houseId);
    }

    public static final class Params {

        private final Long houseId;

        private Params(Long houseId) {
            this.houseId = houseId;
        }

        /**
         * @param houseId the id that point the special house data.
         * @return the params which contains all the information that needed in this use case.
         */
        public static Params setHouse(@NonNull Long houseId) {
            return new Params(houseId);
        }
    }
}
