package uz.epam.secondarraytask.repository;

import uz.epam.secondarraytask.entity.CustomArray;
import uz.epam.secondarraytask.exception.CustomArrayNotFoundException;
import uz.epam.secondarraytask.service.Warehouse;
import uz.epam.secondarraytask.service.impl.WarehouseImpl;

import java.util.*;
import java.util.stream.Collectors;

public class CustomArrayRepository {
    private final Warehouse warehouse = WarehouseImpl.getInstance();
    private List<CustomArray> customArrayList;

    public CustomArrayRepository() {
        customArrayList = new ArrayList<>();
    }

    public CustomArrayRepository(List<CustomArray> customArrayList) {
        this.customArrayList = customArrayList;
    }

    public List<CustomArray> getCustomArrayList() {
        return customArrayList;
    }

    public void setCustomArrayList(List<CustomArray> customArrayList) {
        this.customArrayList = customArrayList;
    }

    public void save(CustomArray customArray) {
        customArrayList.add(customArray);
        warehouse.update(customArrayList);
    }

    public void delete(CustomArray customArray) {
        customArrayList.remove(customArray);
        warehouse.update(customArrayList);
    }

    public CustomArray findCustomArrayById(int id) {
        Optional<CustomArray> optionalCustomArray = customArrayList.stream()
                .filter(customArray -> customArray.getId() == id).findFirst();
        if (optionalCustomArray.isPresent()){
            return optionalCustomArray.get();
        } else throw new CustomArrayNotFoundException("CustomArray not found");
    }

    public List<CustomArray> findCustomArraysThatSumOfElementsEqualsTo(int sum){
        return customArrayList.stream()
                .filter(customArray -> Arrays.stream(customArray.getInts()).sum() == sum)
                .collect(Collectors.toList());
    }
    public List<CustomArray> findCustomArraysThatSumOfElementsGreaterThan(int sum){
        return customArrayList.stream()
                .filter(customArray -> Arrays.stream(customArray.getInts()).sum() >= sum)
                .collect(Collectors.toList());
    }
    public List<CustomArray> findCustomArraysThatSumOfElementsLessThan(int sum){
        return customArrayList.stream()
                .filter(customArray -> Arrays.stream(customArray.getInts()).sum() <= sum)
                .collect(Collectors.toList());
    }

    public void sortById() {
        customArrayList = customArrayList.stream()
                .sorted(Comparator.comparingInt(CustomArray::getId))
                .collect(Collectors.toList());
    }

    public void sortByAmountOfElement() {
        customArrayList = customArrayList.stream()
                .sorted(Comparator.comparingInt(o -> o.getInts().length))
                .collect(Collectors.toList());
    }

}
