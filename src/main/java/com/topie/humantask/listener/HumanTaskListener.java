package com.topie.humantask.listener;

import com.topie.humantask.persistence.domain.TaskInfo;

public interface HumanTaskListener {
    void onCreate(TaskInfo taskInfo) throws Exception;

    void onComplete(TaskInfo taskInfo) throws Exception;
}
