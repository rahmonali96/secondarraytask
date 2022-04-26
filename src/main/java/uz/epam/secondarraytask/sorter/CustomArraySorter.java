package uz.epam.secondarraytask.sorter;

import uz.epam.secondarraytask.entity.CustomArray;
import uz.epam.secondarraytask.repository.CustomArrayRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CustomArraySorter {
    public void sortById(CustomArrayRepository repository) {
        List<CustomArray> customArrayList = repository.getCustomArrayList();
        repository.setCustomArrayList(customArrayList.stream()
                .sorted(Comparator.comparingInt(CustomArray::getId))
                .collect(Collectors.toList()));
    }

    public void sortByAmountOfElement(CustomArrayRepository repository) {
        List<CustomArray> customArrayList = repository.getCustomArrayList();
        repository.setCustomArrayList(customArrayList.stream()
                .sorted(Comparator.comparingInt(o -> o.getInts().length))
                .collect(Collectors.toList()));
    }
}
