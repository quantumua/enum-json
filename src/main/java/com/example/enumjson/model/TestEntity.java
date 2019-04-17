package com.example.enumjson.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.Arrays;

@Data
public class TestEntity {
    private String id;
    private TestEnum testEnum;

    @AllArgsConstructor
    @Getter
    public static enum TestEnum {
        INPUT("INPUT-MY"),
        PARTICIPANT("PARTICIPANT");

        private String value;

    /*    @JsonCreator
        public static TestEnum parse(String value) {
            //return Arrays.stream(TestEnum.values()).filter(te -> te.value.equals(value)).findFirst().orElseThrow(IllegalArgumentException::new);
            return Optional.ofNullable(value)
                    .map(String::toUpperCase)
                    .map(TestEnum::valueOf)
                    .orElse(null);
        }*/

        @JsonCreator
        public static TestEnum parse1(String value) {
            return Arrays.stream(TestEnum.values()).filter(te -> te.value.equals(value.toUpperCase())).findFirst().orElseThrow(IllegalArgumentException::new);

        }

        @JsonValue
        public String parse(){
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
}


