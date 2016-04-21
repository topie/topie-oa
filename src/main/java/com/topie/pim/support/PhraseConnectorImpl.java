package com.topie.pim.support;

import java.util.List;

import javax.annotation.Resource;

import com.topie.api.phrase.PhraseConnector;

import com.topie.pim.persistence.manager.PimPhraseManager;

public class PhraseConnectorImpl implements PhraseConnector {
    private PimPhraseManager pimPhraseManager;

    public List<String> findByUserId(String userId) {
        return pimPhraseManager.find(
                "select content from PimPhrase where userId=?", userId);
    }

    @Resource
    public void setPimPhraseManager(PimPhraseManager pimPhraseManager) {
        this.pimPhraseManager = pimPhraseManager;
    }
}
