package com.soft2242.one.service;

import com.soft2242.one.vo.DoorListItemVO;

import java.util.List;

/**
 * @author : Flobby
 * @program : community-client-api
 * @description :
 * @create : 2023-05-30 11:46
 **/

public interface SmartService {

    List<DoorListItemVO> getDoorList(Long communityId);

    void openDoor(Long doorId, Long userId);
}
