package ro.pao.service.impl;

import ro.pao.model.administration.Subscription;
import ro.pao.service.SubscriptionService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;


import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor
@Getter
public class SubscriptionServiceImpl implements SubscriptionService
{
    private static List<Subscription> subscriptionList = new ArrayList<>();
    @Override
    public Optional<Subscription> getById(UUID id)
    {
        return subscriptionList.stream()
                .filter(object -> id.equals(object.getSubscriptionID()))
                .findFirst();
    }

    @Override
    public Optional<Subscription> getBySomeFieldOfClass(Object someFieldFromClass)
    {
        return Optional.empty();
    }

    @Override
    public List<Subscription> getAll()
    {
        return subscriptionList;
    }

    @Override
    public void addAll(List<Subscription> subscriptionList)
    {
        this.subscriptionList.addAll(subscriptionList);
    }

    @Override
    public void addOne(Subscription subscription)
    {
        this.subscriptionList.add(subscription);
    }

    @Override
    public void removeById(UUID id)
    {
        subscriptionList = subscriptionList.stream()
                .filter(object -> !id.equals(object.getSubscriptionID())).collect(Collectors.toList());
    }

    @Override
    public void modifyById(UUID id, Subscription newSubscription)
    {
        removeById(id);
        addOne(newSubscription);
    }
}
