package uk.gov.hmcts.reform.ref.pup.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.gov.hmcts.reform.ref.pup.repository.ProfessionalUserRepository;
import uk.gov.hmcts.reform.ref.pup.domain.ProfessionalUser;

import java.util.UUID;

@Service
public class ProfessionalUserProfileService {

    private ProfessionalUserRepository professionalUserRepository;

    @Autowired
    public ProfessionalUserProfileService(ProfessionalUserRepository professionalUserRepository) {
        this.professionalUserRepository = professionalUserRepository;
    }

    public ProfessionalUser createProfessionalUser(final ProfessionalUser professionalUserProfile) {
        final UUID uuid = UUID.randomUUID();
        professionalUserProfile.setProOrgId(uuid.toString());
        return professionalUserRepository.save(professionalUserProfile);
    }

    public ProfessionalUser retrieveProfessionalUser(UUID uuid) {
        return professionalUserRepository.findById(uuid).orElse(null);
    }

    public void deleteProfessionalUser(UUID uuid) {
        professionalUserRepository.deleteById(uuid);
    }
}
