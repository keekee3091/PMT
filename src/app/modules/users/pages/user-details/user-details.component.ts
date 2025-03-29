import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-user-details',
  imports: [],
  templateUrl: './user-details.component.html',
  styleUrl: './user-details.component.scss'
})
export class UserDetailComponent {
  userId: number | null = null;

  constructor(private route: ActivatedRoute) {
    this.userId = Number(this.route.snapshot.paramMap.get('id'));
  }
}
