package com.topie.form.engine;

import com.topie.form.engine.model.FormModel;

public interface FormModelCache {
    FormModel getFormModel(String id);

    void setFormModel(FormModel formModel);
}
