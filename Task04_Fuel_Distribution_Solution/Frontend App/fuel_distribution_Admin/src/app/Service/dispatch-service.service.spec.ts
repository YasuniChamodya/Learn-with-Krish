import { TestBed } from '@angular/core/testing';

import { DispatchServiceService } from './dispatch-service.service';

describe('DispatchServiceService', () => {
  let service: DispatchServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DispatchServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
