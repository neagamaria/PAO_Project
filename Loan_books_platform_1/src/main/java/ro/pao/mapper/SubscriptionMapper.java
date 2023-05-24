package ro.pao.mapper;

import ro.pao.model.administration.Subscription;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class SubscriptionMapper {
    private static final SubscriptionMapper INSTANCE = new SubscriptionMapper();

    private SubscriptionMapper() {
    }

    public static SubscriptionMapper getInstance() {
        return INSTANCE;
    }


    public static Optional<Subscription> mapToSubscription(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return Optional.of(
                    Subscription.builder()
                            .subscriptionID(UUID.fromString(resultSet.getString(1)))
                            .price(resultSet.getDouble(2))
                            .validity(resultSet.getInt(3))
                            .build()
            );
        } else {
            return Optional.empty();
        }
    }

    public List<Subscription> mapToSubscriptionList(ResultSet resultSet) throws SQLException {
        List<Subscription> SubscriptionList = new ArrayList<>();
        while (resultSet.next()) {
            SubscriptionList.add(
                    Subscription.builder()
                            .subscriptionID(UUID.fromString(resultSet.getString(1)))
                            .price(resultSet.getDouble(2))
                            .validity(resultSet.getInt(3))
                            .build()
            );
        }

        return SubscriptionList;
    }
}
