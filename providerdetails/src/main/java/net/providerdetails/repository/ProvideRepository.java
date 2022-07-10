package net.providerdetails.repository;

import net.providerdetails.model.Providers;
import org.apache.catalina.authenticator.jaspic.PersistentProviderRegistrations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvideRepository extends JpaRepository<Providers, Long> {
}
