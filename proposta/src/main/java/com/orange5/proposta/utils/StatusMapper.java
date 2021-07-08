package com.orange5.proposta.utils;

import java.util.HashMap;
import java.util.Map;

import com.orange5.proposta.enums.PropostaStatus;

public class StatusMapper {

    public static Map<String, PropostaStatus> statusMap;

    static {
        statusMap = new HashMap<>();
        statusMap.put("COM_RESTRICAO", PropostaStatus.NAO_ELEGIVEL);
        statusMap.put("SEM_RESTRICAO", PropostaStatus.ELEGIVEL);
    }
}
