package saola.com.ngheluon.service.impl;

import org.springframework.stereotype.Service;

import saola.com.ngheluon.dataset.Library;
import saola.com.ngheluon.service.LibraryService;

import java.util.UUID;

@Service
public class LibraryServiceImpl extends BaseServiceImpl<Library, UUID> implements LibraryService {
}
