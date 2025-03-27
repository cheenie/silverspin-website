<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class OrderController extends Controller
{
    /**
     * Get all orders
     */
    public function getOrders(): View
    {
        return view('homepage', [
            'order' => Order::all()
        ]);
    }
    /**
     * Get order by ID
     */
    public function getOrderById(string $id): View
    {
        return view('homepage', [
            'order' => Order::findOrFail($id)
        ]);
    }
}