import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ElegirDepartamentoComponent } from './departamentos-count.component';

describe('DepartamentosCountComponent', () => {
  let component: ElegirDepartamentoComponent;
  let fixture: ComponentFixture<ElegirDepartamentoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ElegirDepartamentoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ElegirDepartamentoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
