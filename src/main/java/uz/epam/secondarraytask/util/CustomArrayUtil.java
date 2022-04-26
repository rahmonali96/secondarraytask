package uz.epam.secondarraytask.util;

import uz.epam.secondarraytask.entity.CustomArray;
import uz.epam.secondarraytask.exception.CustomArrayNotFoundException;
import uz.epam.secondarraytask.repository.CustomArrayRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CustomArrayUtil {
    public CustomArray findCustomArrayById(CustomArrayRepository customArrayRepository, int id) {
        Optional<CustomArray> optionalCustomArray = customArrayRepository.getCustomArrayList().stream()
                .filter(customArray -> customArray.getId() == id).findFirst();
        if (optionalCustomArray.isPresent()){
            return optionalCustomArray.get();
        } else throw new CustomArrayNotFoundException("CustomArray not found");
    }

    public List<CustomArray> findCustomArraysThatSumOfElementsEqualsTo(CustomArrayRepository customArrayRepository, int sum) {
        return customArrayRepository.getCustomArrayList().stream()
                .filter(customArray -> Arrays.stream(customArray.getInts()).sum() == sum)
                .collect(Collectors.toList());
    }

    public List<CustomArray> findCustomArraysThatSumOfElementsGreaterThan(CustomArrayRepository customArrayRepository, int sum) {
        return customArrayRepository.getCustomArrayList().stream()
                .filter(customArray -> Arrays.stream(customArray.getInts()).sum() >= sum)
                .collect(Collectors.toList());
    }

    public List<CustomArray> findCustomArraysThatSumOfElementsLessThan(CustomArrayRepository customArrayRepository, int sum) {
        return customArrayRepository.getCustomArrayList().stream()
                .filter(customArray -> Arrays.stream(customArray.getInts()).sum() <= sum)
                .collect(Collectors.toList());
    }
}
