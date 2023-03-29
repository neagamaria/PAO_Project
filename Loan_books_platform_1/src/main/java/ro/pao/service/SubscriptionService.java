package ro.pao.service;

import ro.pao.model.administration.Subscription;
import java.util.Optional;
import java.util.UUID;
import java.util.List;
public interface SubscriptionService
{
    Optional<Subscription> getById(UUID id);
    Optional<Subscription> getBySomeFieldOfClass(Object someFieldFromClass);
    List<Subscription> getAll();
    void addAll(List<Subscription> subscriptionList);
    void addOne(Subscription subscription);
    void removeById(UUID id);
    void modifyById(UUID id, Subscription newSubscription);
}
