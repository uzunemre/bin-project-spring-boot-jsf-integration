package com.emreuzun.bank.web.converter;

import com.emreuzun.bank.core.annotation.Id;

import javax.faces.component.UIComponent;
import javax.faces.component.UISelectItems;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import java.lang.reflect.Method;
import java.util.List;

@FacesConverter(value = "entityConverter")
public class EntityConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        List<?> selections = getSelectionList(component);
        Object object = null;
        if (selections != null) {
            for (Object selection : selections) {
                String entityId = getEntityIdValue(selection);
                if (value.equals(entityId)) {
                    object = selection;
                    break;
                }
            }
        }
        return object;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return getEntityIdValue(value);
    }

    private List<?> getSelectionList(UIComponent component) {
        UISelectItems items = null;
        for (UIComponent child : component.getChildren()) {
            if (child instanceof UISelectItems) {
                items = (UISelectItems) child;
                break;
            }
        }
        List<?> list = (List<?>) items.getAttributes().get("value");
        return list;
    }

    String getEntityIdValue(Object object) {
        Method method = null;
        String value = null;
        try {
            for (Method m : object.getClass().getMethods()) {
                Id id = m.getAnnotation(Id.class);
                if (id != null || m.getName().equals("getId")) {
                    method = m;
                    break;
                }
            }
            if (method != null) {
                Object val = method.invoke(object);
                value = val.toString();
            }
        } catch (Exception e) {
            value = null;
        }
        return value;
    }

}
