package ro.pao.service.impl;

import lombok.Getter;
import lombok.NoArgsConstructor;
import ro.pao.model.administration.Subscription;
import ro.pao.service.SubscriptionService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

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
    public Optional<List<Subscription>> getByPrice(double price)
    {
        List<Subscription> list = subscriptionList.stream().filter(subscription -> String.valueOf(subscription.getPrice())
                        .equals(String.valueOf(price)))
                        .collect(Collectors.toList());
        return Optional.ofNullable(list);
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
