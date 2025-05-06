package ro.pao.repository;

import ro.pao.model.administration.Subscription;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SubscriptionRepository {
    Optional<Subscription> getObjectById(UUID id);

    void deleteObjectById(UUID id);

    void updateObjectById(UUID id, Subscription newObject);

    void addNewObject(Subscription subscription);

    List<Subscription> getAll();

    void addAllFromGivenList(List<Subscription> subscriptionList);
}
