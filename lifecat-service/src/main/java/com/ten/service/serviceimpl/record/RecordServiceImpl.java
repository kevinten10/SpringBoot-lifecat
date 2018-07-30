package com.ten.service.serviceimpl.record;

import com.ten.entity.AlbumDO;
import com.ten.entity.RecordDO;
import com.ten.service.service.image.AlbumService;
import com.ten.service.service.record.RecordService;
import com.ten.service.serviceimpl.BaseServiceImpl;
import com.ten.vo.AlbumVO;
import com.ten.vo.RecordVO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * record
 *
 * @author Administrator
 */
@Service
public class RecordServiceImpl extends BaseServiceImpl<RecordVO, RecordDO> implements RecordService {

    /**
     * selete all record for all user
     */
    @Override
    public List<RecordVO> all() {
        List<RecordDO> recordDOS = exeQueryAll();
        List<RecordVO> recordVOS = new ArrayList<>(32);
        for (RecordDO recordDO : recordDOS) {
            RecordVO recordVO = new RecordVO(recordDO);
            recordVOS.add(recordVO);
        }
        return recordVOS;
    }

    /**
     * selete all record for user
     * by user_id
     */
    @Override
    public List<RecordVO> list(RecordVO entity) {
        RecordDO record = new RecordDO();
        record.setUserId(entity.getUserId());

        List<RecordDO> recordDOS = exeQueryList(record);

        List<RecordVO> recordVOS = new ArrayList<>(32);
        for (RecordDO recordDO : recordDOS) {
            RecordVO recordVO = new RecordVO(recordDO);
            recordVOS.add(recordVO);
        }
        return recordVOS;
    }

    @Override
    public RecordVO get(RecordVO entity) {
        return null;
    }

    @Override
    public int post(RecordVO entity) {
        return 0;
    }

    @Override
    public int put(RecordVO entity) {
        return 0;
    }

    /**
     * delete record :
     * set is_deleted = 1
     */
    @Override
    public int delete(RecordVO entity) {
        return 0;
    }
}