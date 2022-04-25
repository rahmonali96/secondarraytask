package uz.epam.secondarraytask.repository;

import uz.epam.secondarraytask.entity.CustomArray;
import uz.epam.secondarraytask.exception.CustomArrayNotFoundException;

import java.util.*;
import java.util.stream.Collectors;

public class CustomArrayRepository {
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

    public boolean save(CustomArray customArray) {
        return customArrayList.add(customArray);
    }

    public boolean delete(CustomArray customArray) {
        boolean isDeleted = false;
        for (CustomArray element : customArrayList) {
            if (element.equals(customArray)){
                isDeleted = customArrayList.remove(customArray);
                break;
            }
        }
        return isDeleted;
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
