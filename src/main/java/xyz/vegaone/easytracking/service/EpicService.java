package xyz.vegaone.easytracking.service;

import xyz.vegaone.easytracking.dto.Epic;

public interface EpicService {

    Epic getEpic(Long id);

    Epic createEpic(Epic epic);

    Epic updateEpic(Epic epic);

    void deleteEpic(Epic epic);
}
