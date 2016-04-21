package com.topie.api.dict;

public interface DictConnector {
    DictDTO findDictByName(String dictName, String typeName, String tenantId);

    DictDTO findDictByType(String typeName, String tenantId);
}
