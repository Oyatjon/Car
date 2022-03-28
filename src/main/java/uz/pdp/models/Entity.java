package uz.pdp.models;

import lombok.Getter;

import static uz.pdp.utils.BaseUtils.generateUniqueID;
@Getter
public class Entity {
    private String id = generateUniqueID();
}
