package uz.epam.secondarraytask.service.impl;

import uz.epam.secondarraytask.entity.CustomArray;
import uz.epam.secondarraytask.service.Warehouse;

import java.util.*;

public class WarehouseImpl implements Warehouse {
    private static final WarehouseImpl singleton = new WarehouseImpl();
    private List<CustomArray> customArrayList;

    private WarehouseImpl() {
        this.customArrayList = new ArrayList<>();
    }

    public static WarehouseImpl getInstance() {
        return singleton;
    }

    @Override
    public void update(List<CustomArray> customArrayList) {
        this.customArrayList = customArrayList;
    }

    public int sum() {
        return customArrayList.stream()
                .flatMapToInt(customArray -> Arrays.stream(customArray.getInts())).sum();
    }

    public int max() {
        OptionalInt max = customArrayList.stream()
                .flatMapToInt(customArray -> Arrays.stream(customArray.getInts()))
                .max();
        if (max.isPresent()){
            return max.getAsInt();
        } else return 0;
    }

    public int min() {
        OptionalInt min = customArrayList.stream()
                .flatMapToInt(customArray -> Arrays.stream(customArray.getInts()))
                .min();
        if (min.isPresent()){
            return min.getAsInt();
        } else return 0;
    }

    public double average() {
        OptionalDouble average = customArrayList.stream()
                .flatMapToInt(customArray -> Arrays.stream(customArray.getInts()))
                .average();
        if (average.isPresent()) {
            return average.getAsDouble();
        } else return 0;
    }


}
