package com.ten.controller.image;

import com.ten.controller.BaseController;
import com.ten.dto.ResponseResult;
import com.ten.manager.image.ImageServiceManager;
import com.ten.vo.AlbumVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ten.utils.ControllerCheckUtil.*;

/**
 * album
 *
 * @author Administrator
 */
@RestController
@RequestMapping("/album")
public class AlbumController extends BaseController<AlbumVO, ResponseResult> {

    private final ImageServiceManager imageServiceManager;

    @Autowired
    public AlbumController(ImageServiceManager imageServiceManager) {
        this.imageServiceManager = imageServiceManager;
    }

    /**
     * listById
     * <p>
     * 获取用户所有Album信息
     *
     * @param userId user_id
     * @return listById AlbumVO
     */
    @RequestMapping(value = "/list/{userId}", method = RequestMethod.GET)
    @Override
    public ResponseResult listById(@PathVariable String userId) {
        // check
        checkRequestDataNotNull(userId);
        checkRequestDataFormatInt(userId);
        // execute
        int id = Integer.parseInt(userId);
        List<AlbumVO> albumVOList = imageServiceManager.getAlbumListByUserId(id);
        // return
        checkResourceNotNull(albumVOList);
        return new ResponseResult(albumVOList);
    }

    @Override
    public ResponseResult list(AlbumVO entity) {
        return null;
    }

    /**
     * get
     * <p>
     * 获取某个Album信息
     *
     * @param entity AlbumVO
     * @return AlbumVO
     */
    @RequestMapping(method = RequestMethod.GET)
    @Override
    public ResponseResult get(@RequestBody AlbumVO entity) {
        // check
        checkRequestDataNotNull(entity);
        // execute
        AlbumVO albumVO = imageServiceManager.getAlbumByEntity(entity);
        // return
        checkResourceNotNull(albumVO);
        return new ResponseResult(albumVO);
    }

    /**
     * create
     * <p>
     * 创建Album
     *
     * @param entity AlbumVO
     * @return result
     */
    @RequestMapping(method = RequestMethod.POST)
    @Override
    public ResponseResult post(@RequestBody AlbumVO entity) {
        // check
        checkRequestDataNotNull(entity);
        // execute
        int result = imageServiceManager.createAlbum(entity);
        // return
        checkExecuteResultSuccess(result);
        return new ResponseResult();
    }

    /**
     * update
     * <p>
     * 更新Album信息
     *
     * @param entity AlbumVO
     * @return result
     */
    @RequestMapping(method = RequestMethod.PUT)
    @Override
    public ResponseResult put(@RequestBody AlbumVO entity) {
        // check
        checkRequestDataNotNull(entity);
        // execute
        int result = imageServiceManager.updateAlbum(entity);
        // return
        checkExecuteResultSuccess(result);
        return new ResponseResult();
    }

    /**
     * deleteById
     * <p>
     * 删除Album
     *
     * @param albumId album_id
     * @return result
     */
    @RequestMapping(value = "/{albumId}", method = RequestMethod.DELETE)
    @Override
    public ResponseResult deleteById(@PathVariable String albumId) {
        // check
        checkRequestDataNotNull(albumId);
        checkRequestDataFormatInt(albumId);
        // execute
        int id = Integer.parseInt(albumId);
        int result = imageServiceManager.deleteAlbumByPrimaryKey(id);
        // return
        checkExecuteResultSuccess(result);
        return new ResponseResult();
    }

    @Override
    public ResponseResult delete(AlbumVO entity) {
        return null;
    }
}
